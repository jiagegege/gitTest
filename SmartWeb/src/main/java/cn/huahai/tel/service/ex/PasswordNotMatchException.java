package cn.huahai.tel.service.ex;

/**
 * 用户名或密码不正确
 * @author lizhuodong
 *
 */
public class PasswordNotMatchException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8903428607881147665L;

	public PasswordNotMatchException(String message) {
		super(message);
	}

}
