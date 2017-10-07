package wataanaber.example.github.com.todo.di;

import android.app.Application;
import android.content.Context;

import com.github.gfx.android.orma.AccessThreadConstraint;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import wataanaber.example.github.com.todo.data.model.OrmaDatabase;

@Singleton
@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return application;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return application;
    }

    @Singleton
    @Provides
    public OrmaDatabase provideOrmaDatabase(Context context) {
        return OrmaDatabase
                .builder(context)
                .writeOnMainThread(AccessThreadConstraint.FATAL)
                .readOnMainThread(AccessThreadConstraint.WARNING)
                .build();
    }



}
