public class node {
    Integer val1;
    Integer val2;
    node left;
    node middle1;
    node middle2;
    node right;
    node temp;
    node parent;
    Integer tempVal3;
    int nodeNumber;
    boolean Failure = false;


    public node(int nodeNumber) {

        this.nodeNumber = nodeNumber;
    }

    public Integer getVal1() {
        return val1;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public Integer getVal2() {
        return val2;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }

    public node getLeft() {
        return left;
    }

    public void setLeft(node left) {
        this.left = left;
    }

    public node getMiddle1() {
        return middle1;
    }

    public void setMiddle1(node middle1) {
        this.middle1 = middle1;
    }
    public node getMiddle2() {
        return middle2;
    }

    public void setMiddle2(node middle2) {
        this.middle2 = middle2;
    }

    public node getRight() {
        return right;
    }

    public void setRight(node right) {
        this.right = right;
    }

    public node getTemp() {
        return temp;
    }

    public void setTemp(node temp) {
        this.temp = temp;
    }

    public Integer getTempVal3() {
        return tempVal3;
    }

    public void setTempVal3(Integer tempVal3) {
        this.tempVal3 = tempVal3;
    }

    public int getnodeNumber() {
        return nodeNumber;
    }

    public void setnodeNumber(int twoOrThree) {
        this.nodeNumber = twoOrThree;
    }

    public node getParent() {
        return parent;
    }

    public void setParent(node parent) {
        this.parent = parent;
    }

    public boolean isFailure() {
        return Failure;
    }

    public void setFailure(boolean failure) {
        this.Failure = failure;
    }
}
