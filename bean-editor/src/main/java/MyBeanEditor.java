import java.beans.PropertyEditorSupport;

public class MyBeanEditor extends PropertyEditorSupport {
    private String[] options = {"left","center","right"};

    public String[] getTags(){
        return options;
    }

    @Override
    public String getJavaInitializationString() {
        return ""+getValue();
    }

    @Override
    public String getAsText() {
        int value = (int) getValue();
        return options[value];
    }

    public void setAsText(String s){
        for(int i=0;i<options.length;i++){
            if(options[i].equals(s)){
                setValue(i);
                return;
            }
        }
    }
}
