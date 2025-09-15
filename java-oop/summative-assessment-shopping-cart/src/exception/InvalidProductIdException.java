package exception;

/**
 * A custom unchecked exception to signal that the requested product could not be found.
 *
 * <p>
 *     This exception extends {@link RuntimeException} and does not need to be declared in a method's
 * <code>throws</code> clause.
 * </p>
 *
 * <pre>
 * Example usage:
 *     {@code
 *     if (!productRepo.contains(id)) {
 *         throw new InvalidProductIdException(id);
 *     }
 *     }
 * </pre>
 */
public class InvalidProductIdException extends RuntimeException {
    /**
     * Constructs a new <code>InvalidProductIdException</code> with a detail message that includes the invalid ID.
     *
     * @param id the product ID that could not be found
     */
    public InvalidProductIdException(String id) {
        super("Invalid product id: " + id);
    }
}
