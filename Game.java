
 

public class Game
{
    private Room aCurrentRoom ;
    private Parser aParser ;

    private void createRooms(){
        Room vSpace = new Room("Vous étes perdu dans l'espace");
        Room vTerre = new Room("Vous étes sur la planéte terre");
        Room vSaturne= new Room ("Vous étes sur la planéte Saturne");
        Room vMars = new Room ("Vous étes sur la planéte Mars");
        Room vLune = new Room("Vous étes sur la lune");
        Room vBételgeuse = new Room("Vous arrivée sur le systeme de la Bételgeuse");
        
        vSpace.setExits(vTerre,vMars,vSaturne,vBételgeuse);
        vSaturne.setExits(vSpace,null,null,null);
        vMars.setExits(null,null,null,vSpace);
        vTerre.setExits(vLune,null,vSpace,null);
        vLune.setExits(null,null,vTerre,null);
        vBételgeuse.setExits(null,vSpace,null,null);

       
        this.aCurrentRoom=vSpace;
    }

    public Game(){
        createRooms();
        this.aParser= new Parser();

    }

    public void play(){
        printWelcome();
        boolean vFinished=false;
        while (vFinished == false){
            Command vCommand=aParser.getCommand();
            vFinished=processCommand(vCommand);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void goRoom( final Command pCommande){
        Room vNextRoom = null;
        String vDirection = pCommande.getSecondWord();
        if (!pCommande.hasSecondWord()){
            System.out.println("Go where ?");
            return;

        }
        else{
            Room nextRoom =aCurrentRoom.getExit(vDirection);
            if (vDirection.equals("nord")){
                vNextRoom = aCurrentRoom.getExit("nord");
            }
            if (vDirection.equals("sud")){
                vNextRoom =aCurrentRoom.getExit("sud");
            } 
            if (vDirection.equals("est")){
                vNextRoom =aCurrentRoom.getExit("est");
            }
            if (vDirection.equals("ouest")){
                vNextRoom=aCurrentRoom.getExit("ouest");
            }
           

            /*if(vDirection.equals("North")){
                vNextRoom =this.aCurrentRoom.aNorthExit;

            }
            else if (vDirection.equals("South")){
                vNextRoom =this.aCurrentRoom.aSouthExit;
            }
            else if (vDirection.equals("Est")){
                vNextRoom=this.aCurrentRoom.aEstExit;
            }
            else if (vDirection.equals("West")){
                vNextRoom=this.aCurrentRoom.aWestExit;
            }else{
                System.out.println("Unknow direction !");
            }*/
        }

        if (vNextRoom == null){
            System.out.println("there is not door !");
        }
        else {
            this.aCurrentRoom=vNextRoom;
            System.out.println(this.aCurrentRoom.getDescription());
            if (this.aCurrentRoom.aEstExit !=null){
                System.out.println("est");
            }
            if (this.aCurrentRoom.aNorthExit !=null){
                System.out.println("nord");
            }
            if (this.aCurrentRoom.aSouthExit !=null){
                System.out.println("sud");
            }
            if (this.aCurrentRoom.aWestExit !=null){
                System.out.println("ouest");
            }

        }
    }
    private void printWelcome(){
        System.out.println("Bienvenue dans l'espace, Trouve une planéte habitable");
    }

    private void printHelp(){
        System.out.println("tu es totalement perdu");
    }

    private boolean quit(final Command pCommand ){
        if ( pCommand.hasSecondWord() != false){
            System.out.println("Quit what ?");
            return false ;
        }
        else {

            return true;
        }
    }

    private boolean processCommand(final Command pcCommand){
        if (pcCommand.isUnknown()){
            System.out.println("I don't know what you mean...");
            return false;

        }
        else if (pcCommand.getCommandWord().equals("go")){
            goRoom( pcCommand);
            return false;
        }
        else if (pcCommand.getCommandWord().equals("help")){
            printHelp();
            return false;
        }
        else if (pcCommand.getCommandWord().equals("quit")){
            return quit(pcCommand);

        }
        else return false;
    }

    private void printLocationInfo(){
        System.out.print("Vous etes "+aCurrentRoom.getDescription());
        System.out.print(" les sorties : ");
        if (aCurrentRoom.aNorthExit != null){
            System.out.print("nord "+"\n");
        }
        if (aCurrentRoom.aEstExit != null){
            System.out.print("Est "+"\n");
        }
        if (aCurrentRoom.aSouthExit != null){
            System.out.print("sud "+"\n");
        }
        if (aCurrentRoom.aWestExit != null){
            System.out.print("ouest "+"\n");
        }

    }

}  
// Game

