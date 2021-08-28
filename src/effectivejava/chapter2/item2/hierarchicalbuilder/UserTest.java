package effectivejava.chapter2.item2.hierarchicalbuilder;

import static effectivejava.chapter2.item2.hierarchicalbuilder.User.UserInfo.SEX;
import static effectivejava.chapter2.item2.hierarchicalbuilder.UserMaster.Priviledge.MASTER;

public class UserTest {

	// 유저정보에 추가하는 용도로는 쓰기가 애매한 것으로 보인다.
	public static void main(String[] args) {
		UserMaster userMaster = new UserMaster.Builder(MASTER).addAttri(SEX).build();
	}

}
