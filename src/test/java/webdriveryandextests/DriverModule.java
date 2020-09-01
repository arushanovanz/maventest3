package webdriveryandextests;

import com.google.inject.Binder;
import com.google.inject.Module;

public class DriverModule implements Module {
    String moduleName;

    public DriverModule(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public void configure(Binder binder) {

    }
}
