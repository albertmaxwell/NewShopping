KindEditor.ready(function(K) {
    window.editor = K.create('#editor_id');
});

var options = {
    cssPath : '/css/index.css',
    filterMode : true
};
var editor = K.create('textarea[name="content"]', options);

// 取得HTML内容
html = editor.html();

// 同步数据后可以直接取得textarea的value
editor.sync();
html = document.getElementById('editor_id').value; // 原生API
html = K('#editor_id').val(); // KindEditor Node API
html = $('#editor_id').val(); // jQuery

// 设置HTML内容
editor.html('HTML内容');

/*  // 关闭过滤模式，保留所有标签
  KindEditor.options.filterMode = false;

  KindEditor.ready(function(K)) {
      K.create('#editor_id');
  }*/