package com.tsadigov.erp.ui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tural on 3/23/14.
 *
 * Observable collection
 */
public class SelectableList <T> extends ArrayList<T> {
    Set<T> _selectedList= new HashSet<T>();

    public Set<T> getSelectedList(){
        return _selectedList;
    }

    public boolean isSelected(T item){
        return _selectedList.contains(item);
    }

    public void select(Set<T> item){
        _selectedList.addAll(item);
        for(SelectableListObserver<T> observer:_observers)
            observer.OnSelect(item);
    }

    public void unselect(Set<T> item){
        _selectedList.removeAll(item);
        for(SelectableListObserver<T> observer:_observers)
            observer.OnUnselect(item);
    }

    List<SelectableListObserver<T>> _observers=new ArrayList<SelectableListObserver<T>>();
    public void startObserving(SelectableListObserver<T> observer){
        _observers.add(observer);
    }
    public void stopObserving(SelectableListObserver<T> observer){
        _observers.remove(observer);
    }
}
