 

public class Room
{
    private String aDescription ;
    public Room aNorthExit=null ;
    public Room aEstExit=null;
    public Room aSouthExit=null;
    public Room aWestExit=null;
   
     /**
     * constructeur de Room
     */
     public Room(final String pDescription)
    {
        this.aDescription=pDescription ;
    }
    public String getDescription(){
         return this.aDescription ;
        }
    public void setExits(final Room pNorthExit, final Room pEstExit , final Room pSouthExit, final Room pWestExit  ){
        this.aNorthExit=pNorthExit;
        this.aEstExit=pEstExit;
        this.aSouthExit=pSouthExit;
        this.aWestExit=pWestExit;
       
       
    }//asscesseur de attribut en public
    public Room getExit(String direction){
        if (direction.equals("nord")){
            return aNorthExit ;
        }
        if (direction.equals("est")){
            return aEstExit;
        }
        if (direction.equals("sud")){
            return aSouthExit;
        }
        if (direction.equals("ouest")){
            return aWestExit ;
        }
    return null;
    }
} // Room