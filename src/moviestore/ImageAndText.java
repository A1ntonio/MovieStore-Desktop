
package moviestore;

import javax.swing.Icon;


class ImageAndText {
    
    private String name;
    private Icon image;

    public ImageAndText( String name, Icon image) {
        this.name = name;
        this.image = image;
        
    }

    public String getname() {
        return name;
    }
    public Icon getImage() {
        return image;
    }
    public void setImage() {
        this.image = image;
                }

    public void setname(String name) {
        this.name = name;
    }
    
}
