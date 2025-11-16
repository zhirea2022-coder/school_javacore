package assignments.boxes.v3;

import assignments.figures.v3.Figure;

public class ArrayBox<T extends Figure> {

    private T[] content;

    public ArrayBox(T[] content) {
        super();
        this.content = content;
    }

    public T[] getContent() {
        return content;
    }

    public void setContent(T[] content) {
        this.content = content;
    }

    public T getElement(int i){
        return content[i];
    }

    public void setElement(T element, int i){
        content[i] = element;
    }

    public boolean isSameSize(ArrayBox<? extends Figure> arrayBox){
        return content.length == arrayBox.content.length;
    }
}
