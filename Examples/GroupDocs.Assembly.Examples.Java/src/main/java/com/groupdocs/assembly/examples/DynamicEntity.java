package com.groupdocs.assembly.examples;

import java.util.Arrays;
import java.util.UUID;

//ExStart:DynamicEntity
/**
 * An entity whose properties are fetched by name rather than declared, so a report can be generated
 * lazily and recursively over an object graph of unknown shape.
 *
 * A template reads a property with indexer syntax, e.g. {@code root["Name"]}: the engine resolves
 * an indexer on a Java type through its {@code get(String)} method. The related and child entities
 * are exposed as public fields, because the engine resolves member access such as
 * {@code root.Entities} against a field, not against a {@code getEntities()} getter (see
 * LIBRARY-BUG-REPORTS.md, bug 11).
 */
public class DynamicEntity {

	/**
	 * Provides access to individual related entities by their names.
	 */
	public final ReferencedEntities Entities;

	/**
	 * Provides access to enumerations of related entities by their names.
	 */
	public final ChildEntities Children;

	private final UUID mId;

	public DynamicEntity(UUID id) {
		// In this example we use UUID to represent an entity identifier. In a real-life application
		// the identifier can be of any type or even missing.
		mId = id;

		// In this example we simply initialize the fields in the constructor. In a real-life
		// application the lookups below can fetch their data lazily, when they are first called.
		Entities = new ReferencedEntities(this);
		Children = new ChildEntities(this);
	}

	/**
	 * Gets a property value by its name.
	 */
	public String get(String propertyName) {
		// In this example we simply return a property name as its value. In a real-life application
		// a real property value should be returned. This value can be cached using for example a
		// Map, or fetched every time the property is requested.
		return propertyName + " Value";
	}

	public static class ReferencedEntities {
		private final DynamicEntity mRootEntity;

		ReferencedEntities(DynamicEntity rootEntity) {
			// The reference to the root entity allows to access fields of the root entity (such as
			// an identifier) in the lookup below for a real-life application.
			mRootEntity = rootEntity;
		}

		public DynamicEntity get(String propertyName) {
			// In this example we simply return the root entity. In a real-life application an entity
			// corresponding to propertyName for the given root entity should be returned.
			return mRootEntity;
		}
	}

	public static class ChildEntities {
		private final DynamicEntity mRootEntity;

		ChildEntities(DynamicEntity rootEntity) {
			mRootEntity = rootEntity;
		}

		public Iterable<DynamicEntity> get(String propertyName) {
			// In this example we simply return the root entity three times. In a real-life application
			// the entities corresponding to propertyName for the given root entity should be returned.
			return Arrays.asList(mRootEntity, mRootEntity, mRootEntity);
		}
	}
}
//ExEnd:DynamicEntity
