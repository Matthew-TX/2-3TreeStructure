import java.util.ArrayList;

public class TwoThreeTree {
    node root = new node(2);
    String inOrderString = "";
    node repeatedValue = new node(-1);

    Integer level = 0;
    String levelsString = "";
    public TwoThreeTree() {
        root.setFailure(true);
    }

    public node Search(node N, Integer V) {

            if (N.getnodeNumber() == 2) {
                return Search2(N, V);
            } else if (N.getnodeNumber() == 3) {
                return Search3(N, V);
            }
            return N;
    }

    public node Search2(node N, Integer V) {
        if (N.getVal1() == null){
            return N;
        }
        if (N.getVal1().equals(V)) {
            return repeatedValue;
        }
        if (V < N.getVal1()) {
            if (N.getLeft() != null) {
                return Search(N.getLeft(), V);
            } else {
                N.setFailure(true);
                return N;
            }
        }
        else {
            if (N.getRight() != null) {
                return Search(N.getRight(), V);
            }
            else {
                N.setFailure(true);
                return N;
            }
        }

    }

    public node Search3(node N, Integer V) {
        if (N.getVal1() == V) {
            return repeatedValue;
        } else if (N.getVal2() == V) {
            return repeatedValue;
        } else if (V < N.getVal1()) {
            if (N.getLeft() != null) {
                return Search(N.getLeft(), V);
            } else {
                N.setFailure(true);
                return N;
            }
        } else if (V > N.getVal2()) {
            if (N.getRight() != null) {
                return Search(N.getRight(), V);
            } else {
                N.setFailure(true);
                return N;
            }

        } else if (N.getMiddle1() != null) {
            return Search(N.getMiddle1(), V);
        } else {
            N.setFailure(true);
            return N;
        }
    }

    public void Split(node N) {
        node A = new node(2);
        node B = new node(2);

        A.setVal1(N.getVal1());
        A.setLeft(N.getLeft());
        A.setRight(N.getMiddle1());

        B.setVal1(N.getTempVal3());
        B.setLeft(N.getMiddle2());
        B.setRight(N.getRight());

        if (N == root) {
            root = new node(2);
            root.setVal1(N.getVal2());
            root.setLeft(A);
            root.setRight(B);
            A.setParent(root);
            B.setParent(root);
        }
        else if (N.getParent().getnodeNumber() == 2) {
            node x = new node(3);
            x.setParent(N.getParent().getParent());
            A.setParent(x);
            B.setParent(x);
            if (N.getParent().getRight() == N) {
                x.setLeft(N.getParent().getLeft());
                x.setMiddle1(A);
                x.setRight(B);
                x.setVal1(N.getParent().getVal1());
                x.setVal2(N.getVal2());

            } else {
                x.setLeft(A);
                x.setMiddle1(B);
                x.setRight(N.getParent().getRight());
                x.setVal1(N.getVal2());
                x.setVal2(N.getParent().getVal1());
            }
//Replace N.P with X
            if (N.getParent().getParent() == null || N.getParent() == root) {
                root = x;
            } else if (N.getParent() == N.getParent().getParent().getLeft()) {
                N.getParent().getParent().setLeft(x);
            } else if (N.getParent() == N.getParent().getParent().getRight()) {
                N.getParent().getParent().setRight(x);
            } else if (N.getParent() == N.getParent().getParent().getMiddle1()) {
                N.getParent().getParent().setMiddle1(x);
            }
        }
        else {
            node x = new node(4);
            x.setParent(N.getParent().getParent());
            A.setParent(x);
            B.setParent(x);

            if (N.getParent().getRight() == N) {
                x.setLeft(N.getParent().getLeft());
                x.setMiddle1(N.getParent().getMiddle1());
                x.setMiddle2(A);
                x.setRight(B);
                x.setVal1(N.getParent().getVal1());
                x.setVal2(N.getParent().getVal2());
                x.setTempVal3(N.getVal2());
            } else if (N.getParent().getLeft() == N) {
                x.setRight(N.getParent().getRight());
                x.setMiddle2(N.getParent().getMiddle1());
                x.setMiddle1(B);
                x.setLeft(A);
                x.setTempVal3(N.getParent().getVal2());
                x.setVal2(N.getParent().getVal1());
                x.setVal1(N.getVal2());
            } else {
                x.setLeft(N.getParent().getLeft());
                x.setMiddle1(A);
                x.setMiddle2(B);
                x.setRight(N.getParent().getRight());
                x.setVal1(N.getParent().getVal1());
                x.setTempVal3(N.getParent().getVal2());
                x.setVal2(N.getVal2());
            }
            //Replace N.P with X
            if (N.getParent() == root || N.getParent().getParent() == null) {
                root = x;
            } else if (N.getParent() == N.getParent().getParent().getLeft()) {
                N.getParent().getParent().setLeft(x);
            } else if (N.getParent() == N.getParent().getParent().getRight()) {
                N.getParent().getParent().setRight(x);
            } else if (N.getParent() == N.getParent().getParent().getMiddle1()) {
                N.getParent().getParent().setMiddle1(x);
            }
            Split(x);
        }

    }

    public void Insert(node N, Integer V) {
        node Q = Search(N, V);
        if (Q != repeatedValue && Q!=null){
            if (Q.isFailure()) {
                Q.setFailure(false);
                if (Q.getnodeNumber() == 2) {
                    if (Q.getVal1() == null) {
                        Q.setVal1(V);
                    } else if (V > Q.getVal1()) {
                        Q.setnodeNumber(3);
                        Q.setVal2(V);
                    } else if (V < Q.getVal1()) {
                        Q.setnodeNumber(3);
                        Q.setVal2(Q.getVal1());
                        Q.setVal1(V);
                    }

                } else {
                    Q.setnodeNumber(4);
                    if (V > Q.getVal2()) {
                        Q.setTempVal3(V);
                    } else if (V > Q.getVal1()) {
                        Q.setTempVal3(Q.getVal2());
                        Q.setVal2(V);
                    } else if (V < Q.getVal1()) {
                        Q.setTempVal3(Q.getVal2());
                        Q.setVal2(Q.getVal1());
                        Q.setVal1(V);
                    }
                    Split(Q);
                }
            }

        }

    }

    public void insert(Integer value) {
        if(value != null){
            Insert(root, value);
        }
    }

    public Integer getMax() {
        node current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        if (current.getTempVal3() != null) {
            return current.getTempVal3();
        }
        if (current.getVal2() != null) {
            return current.getVal2();
        } else {
            return current.getVal1();
        }
    }

    public String displayInOrder() {
        String displayInOrder = this.InOrder(root);
        inOrderString = "";
        return displayInOrder;
    }

    public String InOrder(node n) {


        if (n != null) {
            if (n.getLeft() != null) {
                this.InOrder(n.getLeft());
            }
            if (n.getVal1() != null ) {
                inOrderString += n.getVal1() + ",";
            }
            if (n.getMiddle1() != null) {
                this.InOrder(n.getMiddle1());
            }
            if (n.getVal2() != null && n.getnodeNumber()>2) {
                inOrderString += n.getVal2() + ",";
            }
            if (n.getRight() != null) {
                this.InOrder(n.getRight());
            }
            if (n.getTempVal3() != null && n.getnodeNumber()>2) {
                inOrderString += n.getTempVal3() + ",";
            }
            return inOrderString;
        } else {
            return "The tree is empty";
        }

    }


}
