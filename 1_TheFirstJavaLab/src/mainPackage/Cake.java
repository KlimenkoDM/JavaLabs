package mainPackage;

import com.company.Food;

public class  Cake extends Food {
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cake)) {
            return false;
        } else if (size == null || ((Cake) obj).size == null) {  // размер не задан
            return false;
        }
        else if (!(size.equals(((Cake) obj).size))) {
            return false;
        }
        return super.equals(obj);
    }

    private String size;

    public String getSize(){
        return size;
    }

    public Cake(String size){
        super ("Cake");
        this.size = size;
    }

    public void consume(){
        System.out.println(this + " eaten");
    }

    @Override
    public String toString() {
        return super.toString() + " icing '" + size.toUpperCase() + "'";
    }
}
