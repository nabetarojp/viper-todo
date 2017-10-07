package wataanaber.example.github.com.todo.ui.create;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import wataanaber.example.github.com.todo.R;
import wataanaber.example.github.com.todo.databinding.ActivityCreateTodoBinding;

public class CreateTodoActivity extends AppCompatActivity implements CreateTodoContract.View {

    @Inject
    CreateTodoContract.Presenter presenter;
    ActivityCreateTodoBinding binding;

    public static Intent createIntent(Context context) {
        return new Intent(context, CreateTodoActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_todo);
        binding.setView(this);
        binding.toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(binding.toolbar);

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public void showError(String message) {
        binding.progressBar.setVisibility(View.GONE);
        binding.errorText.setVisibility(View.VISIBLE);
        binding.errorText.setText(message);
    }

    public void save(View v) {
        String t = binding.titleEdit.getText().toString();
        String c = binding.contentEdit.getText().toString();
        if (t.isEmpty() || c.isEmpty()) {
            Toast.makeText(this, "input title or content!", Toast.LENGTH_SHORT).show();
            return;
        }
        presenter.saveTodo(t, c);
    }
}
