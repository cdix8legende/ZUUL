public class Command{
    private String aCommandWord;
    private String aSecondWord ;
   
    public Command(final String pCommandWord ,final String pSecondWord){
        this.aCommandWord=pCommandWord;
        this.aSecondWord=pSecondWord;
    }
    public String getCommandWord(){
        return this.aCommandWord;
    }
    public String getSecondWord(){
        return this.aSecondWord;
    }
    public boolean hasSecondWord()
    {
        return this.aSecondWord!=null;
 
    }
    public boolean isUnknown(){
        boolean vérifmot1=false;
        if (this.aCommandWord == null){
            vérifmot1=true;
        }
        return vérifmot1;
    }      
} // Command

