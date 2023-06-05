let post = {
    init: function () {
        let _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save: function (){
        let data = {
            title: $('#title').val(),
            content: $('#content').val(),
            writer: $('#writer').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/post',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8,',
            data: JSON.stringify(data),
        }).done(function() {
            alert("등록");
            window.location.href = "/board";
        }).fail(function (){
            alert("실패");
        })
    },
    update: function (){
        let data = {
            title: $('#title').val(),
            content: $('#content').val()
        };
        let nno = $('#nno').val();
        $.ajax({
            type: 'PUT',
            url: '/api/post/' + nno,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8,',
            data: JSON.stringify(data),
        }).done(function() {
            alert("등록");
            window.location.href = "/board";
        }).fail(function (){
            alert("실패");
        })
    },
    delete: function (){
        let nno = $('#nno').val();
        $.ajax({
            type: 'DELETE',
            url: '/api/post/' + nno,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8,',
        }).done(function() {
            alert("삭제");
            window.location.href = "/board";
        }).fail(function (){
            alert("실패");
        })
    }
};
post.init();