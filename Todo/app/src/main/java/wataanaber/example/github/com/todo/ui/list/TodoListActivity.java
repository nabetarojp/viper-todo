package wataanaber.example.github.com.todo.ui.list;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.annimon.stream.Stream;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import wataanaber.example.github.com.todo.R;
import wataanaber.example.github.com.todo.data.model.Todo;
import wataanaber.example.github.com.todo.databinding.ActivityTodoListBinding;

public class TodoListActivity extends AppCompatActivity implements TodoListContract.View {

    @Inject
    TodoListContract.Presenter presenter;
    ActivityTodoListBinding binding;
    TodoAdapter adapter;
    LinearLayoutManager layoutManager;

    public static Intent createIntent(Context context) {
        return new Intent(context, TodoListActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_todo_list);
        binding.setView(this);

        binding.toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(binding.toolbar);

        initRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
        presenter.fetchTodos();
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

    @Override
    public void showTodos(List<Todo> todos) {
        if (adapter == null) {
            adapter = new TodoAdapter(this, todos, presenter);
            binding.recyclerView.setAdapter(adapter);
        }
        binding.errorText.setVisibility(View.GONE);
        Stream.of(todos).forEach(todo -> Log.d("", todo.toString()));

    }

    @Override
    public void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showEmpty() {
        binding.errorText.setText("Todo is empty.");
        binding.errorText.setVisibility(View.VISIBLE);
    }

    private void initRecyclerView() {
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        binding.recyclerView.addItemDecoration(dividerItemDecoration);
    }

    public void onClickCreate(View view) {
        presenter.openCreateTodo();
    }
}
