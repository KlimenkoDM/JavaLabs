package mainPackage;

import com.company.Food;

public class Apple extends Food {
    @Override // явное переопределение метода
    public boolean equals(Object obj) {
        if (!(obj instanceof Apple)) {
            return false;
        } else if (size == null || ((Apple) obj).size == null) {  // размер не задан
            return false;
        }
        else if (!(size.equals(((Apple) obj).size))) {
            return false;
        }
        return super.equals(obj);
    }

    private String size;

    public String getSize(){
        return size;
    }

    public Apple(String size){
        super ("Apple");
        this.size = size;
    }

    public void consume()
    {
        System.out.println(this + " eaten");
    }

    @Override
    public String toString() {
        return super.toString() + " size '" + "FFF" + "'";
    }
}
