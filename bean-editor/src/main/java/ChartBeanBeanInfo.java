import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class ChartBeanBeanInfo extends SimpleBeanInfo {
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor descriptor = new PropertyDescriptor("titlePosition",ChartBean.class);
            descriptor.setPropertyEditorClass(MyBeanEditor.class);

//            PropertyDescriptor inverseDescriptor =
//                    new PropertyDescriptor("inverse",ChartBean.class);
//            inverseDescriptor.setPropertyEditorClass();
            return new PropertyDescriptor[]{descriptor};
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
