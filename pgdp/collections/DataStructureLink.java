package pgdp.collections;

public class DataStructureLink<T>{
    private DataStructureConnector<T> dataA;
    private DataStructureConnector<T> dataB;

    public DataStructureLink(DataStructureConnector<T> dataA, DataStructureConnector<T> dataB) {
        this.dataA = dataA;
        this.dataB = dataB;
    }

    public boolean moveNextFromAToB(){
        if (!dataA.hasNextElement()) return false;
        T temp = (dataA.removeNextElement());
        if(temp != null){
            dataB.addElement(temp);
        }
        return true;
    }

    public void moveAllFromAToB(){
      while (dataA.hasNextElement()){
          moveNextFromAToB();
      }
    }

}
