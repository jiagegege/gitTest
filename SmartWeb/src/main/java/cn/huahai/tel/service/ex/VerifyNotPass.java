package cn.huahai.tel.service.ex;

/**
 * 验证码不正确
 * @author lizhuodong
 *
 */
public class VerifyNotPass extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2530089302794616009L;

	public VerifyNotPass(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
}
