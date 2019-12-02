
public class NoItemInShoppingTrolleyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoItemInShoppingTrolleyException() {
		super("No items in shopping trolley.");
	}
	
	public NoItemInShoppingTrolleyException(String message) {
		super(message);
	}

}
