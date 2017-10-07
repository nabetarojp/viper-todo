package wataanaber.example.github.com.todo.data.repository.todo;


import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import wataanaber.example.github.com.todo.data.model.Todo;
import wataanaber.example.github.com.todo.data.repository.DataSource;

/**
 * Created by watanabe on 2017/10/07.
 */

public interface TodoDataSource extends DataSource<Todo> {

    Observable<Todo> fetchAsObservable(long id);
    Single<List<Todo>> fetchAllAsSingle();
}
