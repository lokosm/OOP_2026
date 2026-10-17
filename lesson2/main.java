// мебельная фабрика


interface IChair {
    void sit();
}

interface ISofa {
    void rest();
}

interface ITable {
    void use();
}


class ClassicChair implements IChair {
    public void sit() {
        System.out.println("classic chair");
    }
}
class ClassicSofa implements ISofa {
    public void rest() {
        System.out.println("Classic sofa");
    }
}

class ClassicTable implements ITable {
    public void use() {
        System.out.println("classic table");
    }
}

class ModernChair implements IChair {
    public void sit() {
        System.out.println("modern chair");
    }
}
class ModernSofa implements ISofa {
    public void rest() {
        System.out.println("modern sofa");
    }
}

class ModernTable implements ITable {
    public void use() {
        System.out.println("modern table");
    }
}

// абстрактная фабрика
interface IFurnitureFactory {
    IChair createChair();
    ISofa createSofa();
    ITable createTable();
}

class ClassicFurnitureFactory implements IFurnitureFactory {
    public IChair createChair() {
        return new ClassicChair();
    }
    public ISofa createSofa() {
        return new ClassicSofa();
    }
    public ITable createTable() {
        return new ClassicTable();
    }
}

class ModernFurnitureFactory implements IFurnitureFactory {
    public IChair createChair() {
        return new ModernChair();
    }
    public ISofa createSofa() {
        return new ModernSofa();
    }
    public ITable createTable() {
        return new ModernTable();
    }
}

public class main {
    public static void main(String[] args) {
        IFurnitureFactory factory = new ClassicFurnitureFactory();
        IChair chair = factory.createChair();
        ISofa sofa = factory.createSofa();
        ITable table = factory.createTable();
        chair.sit();
        sofa.rest();
        table.use();
    }
    
}
