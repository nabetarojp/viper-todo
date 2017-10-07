package wataanaber.example.github.com.todo.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import wataanaber.example.github.com.todo.R;
import wataanaber.example.github.com.todo.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {

    @Inject
    SplashContract.Presenter presenter;
    ActivitySplashBinding binding;

    public static Intent createIntent(Context context) {
        return new Intent(context, SplashActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);


    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
        Snackbar.make(binding.getRoot(), "Hi", Snackbar.LENGTH_SHORT).show();
        new Handler().postDelayed(() -> presenter.openTodoList(), 1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void showError(String message) {
        Snackbar.make(binding.getRoot(), "Hi", Snackbar.LENGTH_SHORT).show();
    }
}
