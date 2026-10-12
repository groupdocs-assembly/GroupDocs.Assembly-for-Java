package com.groupdocs.assembly.examples;

import java.util.ArrayList;
import java.util.Collection;

//ExStart:FeatureEntities
/**
 * A data model whose Boolean flag is declared on a base interface, used to show that the engine
 * resolves members a data object inherits from its base interfaces.
 */
public class FeatureEntities {

	// The Boolean flag lives on the deepest base interface ...
	public interface IToggleable {
		boolean getDisabled();
	}

	// ... the display title on the middle one ...
	public interface INamedItem extends IToggleable {
		String getTitle();
	}

	// ... and the elements are exposed through the most-derived interface.
	public interface IFeatureItem extends INamedItem {
		String getCategory();
	}

	public static class FeatureItem implements IFeatureItem {
		private final String mTitle;
		private final boolean mDisabled;
		private final String mCategory;

		public FeatureItem(String title, boolean disabled, String category) {
			mTitle = title;
			mDisabled = disabled;
			mCategory = category;
		}

		public String getTitle() {
			return mTitle;
		}

		public boolean getDisabled() {
			return mDisabled;
		}

		public String getCategory() {
			return mCategory;
		}
	}

	public static class FeatureList {
		private final String mName;
		// The element type is the interface IFeatureItem, so the engine resolves getDisabled()
		// against an interface hierarchy rather than a concrete class.
		private final Collection<IFeatureItem> mItems = new ArrayList<IFeatureItem>();

		public FeatureList(String name) {
			mName = name;
		}

		public String getName() {
			return mName;
		}

		public Collection<IFeatureItem> getItems() {
			return mItems;
		}
	}
}
//ExEnd:FeatureEntities
