package effectivejava.chapter2.item2.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class User {
	public enum UserInfo {
		AGE, NAME, SEX, USERID, EMAIL, CELLPHONE
	}

	final Set<UserInfo> userinfos;

	abstract static class Builder<T extends Builder<T>> {
		EnumSet<UserInfo> userInfos = EnumSet.noneOf(UserInfo.class);

		public T addAttri(UserInfo info) {
			userInfos.add(Objects.requireNonNull(info));
			return self();
		}

		abstract User build();

		protected abstract T self();
	}

	User(Builder<?> builder) {
		userinfos = builder.userInfos.clone();
	}

}
