public public class Notebooks {
    String id;
    String model;
    String processor;
    String ram;
    String hdd;
    String color;

    public Notebooks(String id, String model, String processor, String ram, String hdd, String color) {
        this.id = id;
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.hdd = hdd;
        this.color = color;
    }

    public String toString() {
        return String.format(id, model, processor, ram, hdd, color);
    }

    public String GetInfo(String filter) {
        if(filter == 'id'){   //что-то пошло не так
            return id;
        } else if (filter == 'Model'){
            return model;
        } else if(filter == 'Processor'){
            return processor;
        } else if(filter == 'RAM'){
            return ram;
        }else if(filter == 'HDD'){
            return hdd;
        }else if(filter == 'Color'){
            return color;
        } else{
            return 'product id - ' + id;
        }
    }
} Notebook {
    
}
