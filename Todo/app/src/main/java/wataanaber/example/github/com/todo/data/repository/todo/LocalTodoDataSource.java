package wataanaber.example.github.com.todo.data.repository.todo;

import android.util.Log;

import com.annimon.stream.Stream;
import com.github.gfx.android.orma.annotation.OnConflict;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import wataanaber.example.github.com.todo.data.model.OrmaDatabase;
import wataanaber.example.github.com.todo.data.model.Todo;

/**
 * Created by watanabe on 2017/10/02.
 */

public class LocalTodoDataSource implements TodoDataSource {

    private static final String TAG = "LocalTodoDataSource";

    private OrmaDatabase ormaDatabase;

    @Inject
    public LocalTodoDataSource(OrmaDatabase ormaDatabase) {
        this.ormaDatabase = ormaDatabase;
    }

    @Override
    public void add(Todo item) {
        ormaDatabase.prepareInsertIntoTodoAsSingle(OnConflict.REPLACE)
                .flatMap(todoInserter -> todoInserter.executeAsSingle(item))
                .subscribeOn(Schedulers.io())
                .subscribe((rowId)-> Log.d(TAG, "inserted: " + rowId));
    }

    @Override
    public void add(List<Todo> items) {
        Stream.of(items).forEach(this::add);
    }

    @Override
    public void update(Todo item) {
        add(item);
    }

    @Override
    public void update(List<Todo> items) {
        add(items);
    }

    @Override
    public void remove(Todo item) {
        ormaDatabase.deleteFromTodo().idEq(item.id).executeAsSingle()
                .subscribeOn(Schedulers.io())
                .subscribe(count -> Log.d(TAG, "delete count: " + count));
    }

    @Override
    public Observable<Todo> fetchAsObservable(long id) {
        return ormaDatabase.selectFromTodo().idEq(id).executeAsObservable();
    }

    @Override
    public Single<List<Todo>> fetchAllAsSingle() {
        return ormaDatabase.selectFromTodo().orderByIdAsc().executeAsObservable().toList();
    }

    @Override
    public boolean isEmpty() {
        return ormaDatabase.relationOfTodo().isEmpty();
    }
}
