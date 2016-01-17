package lists;

/**
 * Using Builder pattern to create immutable objects.
 * 
 * @author Nick-s
 *
 */
public class Update 
{
	private final Author author;
	private final String updateText;

	private Update(Builder b_)
	{
		author = b_.author;
		updateText = b_.updateText;
	}

	@Override
	public String toString() {
		return this.author.getAuthorName() + "[" + this.updateText + "]";
	}

	public static class Builder implements ObjBuilder<Update> {
		private Author author;
		private String updateText;


		public Builder author(Author author) {
			this.author = author;

			return this;
		}


		public Builder updateText(String updateText) {
			this.updateText = updateText;

			return this;
		}


		@Override
		public Update build() {
			return new Update(this);
		}

	} 
}
