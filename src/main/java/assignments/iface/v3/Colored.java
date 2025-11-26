package assignments.iface.v3;

import assignments.colors.v3.Color;
import assignments.colors.v3.ColorException;

public interface Colored {

    void setColor(Color color) throws ColorException;

    Color getColor();

    void setColor(String colorString) throws ColorException;
}
