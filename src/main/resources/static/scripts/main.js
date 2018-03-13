var l10n = require('./modules/l10n');

var TodoMain = require('./components/TodoMain');
var AddTodos = require('./components/AddTodos');
var TodoList = require('./components/TodoList');
var TodoActionsBar = require('./components/TodoActionsBar');

function init() {
    var enDictionary = {
        'todosCountLabel': ['item left ', 'items left']
    };
    l10n.provideDict('en', enDictionary);

    var todoMain = new TodoMain();
    var addTodos = new AddTodos();
    var todoList = new TodoList();
    var todoActionsBar = new TodoActionsBar();



    addTodos
        .on('newTodo',
            function (todoData) {
            todoList.createItem(todoData); }
        )
        .on('markAsReadyAll',
            function () { todoList.markAsReadyAll();}
        );

    function itemsCountWatcher () {
        var itemsCount = todoList.getItemsCount();

        console.log(itemsCount);

        if (itemsCount !== 0) {
            todoMain.showFullInterface();
        } else {
            todoMain.hideFullInterface();
        }

        todoActionsBar.setItemsCount(itemsCount);
    }

    todoList.on('itemAdd', itemsCountWatcher)
        .on('itemDelete', itemsCountWatcher);

    todoActionsBar.on(
        'clearCompleted',
        function () { todoList.removeCompletedItems();}
    );

    todoActionsBar.on('filterSelected', function (filterId) {
        todoList.setFilter(filterId);
    });

}

document.addEventListener('DOMContentLoaded', init);