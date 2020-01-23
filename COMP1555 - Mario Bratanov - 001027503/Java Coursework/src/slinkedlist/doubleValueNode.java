package slinkedlist;

/**
 *
 * @author Cos Ierotheou
 */
public class doubleValueNode {
    // Instance variables:

    private Double newtonRaphson;
    private doubleValueNode next;

    /**
     * Creates a node with null references to its element and next node.
     */
    public doubleValueNode() {
        this(0.0, null);
    }

    /**
     * Creates a node with the given element and next node.
     */
    public doubleValueNode(Double e, doubleValueNode n) {
        newtonRaphson = e;
        next = n;
    }
    // Accessor methods:

    public Double getNewtonRaphson() {
        return newtonRaphson;
    }

    public doubleValueNode getNext() {
        return next;
    }
    // Modifier methods:

    public void setNewtonRaphson(Double newNewtonR) {
        newtonRaphson = newNewtonR;
    }

    public void setNext(doubleValueNode newNext) {
        next = newNext;
    }
}
