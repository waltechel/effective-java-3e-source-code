package effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.Objects;

public class UserMaster extends User {

	public enum Priviledge {
		MASTER, NORMAL, ADMIN
	}

	private final Priviledge pri;

	public static class Builder extends User.Builder<Builder> {

		private final Priviledge pri;

		public Builder(Priviledge pri) {
			this.pri = Objects.requireNonNull(pri);
		}

		@Override
		public UserMaster build() {
			return new UserMaster(this);
		}

		@Override
		protected Builder self() {
			return this;
		}

	}

	private UserMaster(Builder builder) {
		super(builder);
		// The blank final field pri may not have been initialized
		pri = builder.pri;
	}
}
