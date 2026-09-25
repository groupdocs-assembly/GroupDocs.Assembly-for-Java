package com.groupdocs.assembly.examples;

import java.util.Arrays;
import java.util.UUID;

//ExStart:DynamicEntity
/**
 * An entity whose properties are fetched by name rather than declared, so a report can be generated
 * lazily and recursively over an object graph of unknown shape.
 *
 * NOTE: the .NET counterpart of this example exposes the lookups as C# indexers, which lets a
 * template write {@code root["Name"]}. The Java template engine does not resolve an indexer on a
 * Java type (see LIBRARY-BUG-REPORTS.md), so here the same lookups are exposed as ordinary methods
 * and the template calls {@code root.getProperty("Name")} instead.
 */
public class DynamicEntity {

	private final UUID mId;
	private final ReferencedEntities mEntities;
	private final ChildEntities mChildren;

	public DynamicEntity(UUID id) {
		// In this example we use UUID to represent an entity identifier. In a real-life application
		// the identifier can be of any type or even missing.
		mId = id;

		// In this example we simply initialize the fields in the constructor. In a real-life
		// application these fields can be initialized lazily at the corresponding getters, if needed.
		mEntities = new ReferencedEntities(this);
		mChildren = new ChildEntities(this);
	}

	/**
	 * Gets a property value by its name.
	 */
	public String getProperty(String propertyName) {
		// In this example we simply return a property name as its value. In a real-life application
		// a real property value should be returned. This value can be cached using for example a
		// Map, or fetched every time the property is requested.
		return propertyName + " Value";
	}

	/**
	 * Provides access to individual related entities by their names.
	 */
	public ReferencedEntities getEntities() {
		return mEntities;
	}

	/**
	 * Provides access to enumerations of related entities by their names.
	 */
	public ChildEntities getChildren() {
		return mChildren;
	}

	public static class ReferencedEntities {
		private final DynamicEntity mRootEntity;

		ReferencedEntities(DynamicEntity rootEntity) {
			// The reference to the root entity allows to access fields of the root entity (such as
			// an identifier) in the lookup below for a real-life application.
			mRootEntity = rootEntity;
		}

		public DynamicEntity getEntity(String propertyName) {
			// In this example we simply return the root entity.
			return mRootEntity;
		}
	}

	public static class ChildEntities {
		private final DynamicEntity mRootEntity;

		ChildEntities(DynamicEntity rootEntity) {
			mRootEntity = rootEntity;
		}

		public Iterable<DynamicEntity> getEntities(String propertyName) {
			// In this example we simply return the root entity three times.
			return Arrays.asList(mRootEntity, mRootEntity, mRootEntity);
		}
	}
}
//ExEnd:DynamicEntity
