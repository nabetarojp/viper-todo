package wataanaber.example.github.com.todo.ui.edit;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import wataanaber.example.github.com.todo.R;
import wataanaber.example.github.com.todo.databinding.ActivityEditTodoBinding;

public class EditTodoActivity extends AppCompatActivity implements EditTodoContract.View {

    @Inject
    EditTodoContract.Presenter presenter;
    ActivityEditTodoBinding binding;

    public static Intent createIntent(Context context) {
        return new Intent(context, EditTodoActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_todo);

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
}
