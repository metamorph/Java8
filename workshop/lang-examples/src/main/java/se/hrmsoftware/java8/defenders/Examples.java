package se.hrmsoftware.java8.defenders;

/**
 * 'Defender methods' - interface methods with default implementation - was added to Java 8 primarily to
 * enable Lambdas and Streams on existing interfaces (java.util.Collection et al).
 *
 * They also serve as a nice way of adding new methods to interfaces while maintaining backward compatibility.
 */
public class Examples {

	public interface Service {
		void ping();

		/*
		default String hello(String name) {
			ping();
			return String.format("Hello, %s", name);
		}
		*/
	}

	/**
	 * "Multiple inheritance"?
	 */
	public interface OtherService {
		default String hello(String name) {
			return "My Zay Hello " + name;
		}
	}


	public static class ServiceImpl implements Service/*, OtherService*/ {
		@Override
		public void ping() {
			System.out.println("PING");
		}
	}


	public static void main(String[] args) {

		Service svc = new ServiceImpl();
		svc.ping();

		/*
		System.out.println(svc.hello());
		*/


	}

}
