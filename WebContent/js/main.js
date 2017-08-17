$(document).ready(function() {

    /*******************************
    * 関数名 |
    * 概要   | 検索ボタンクリック時
    ******************************/
	$("#search").click(function(){

	  // モード変更
      $("#mode").text("検索モード");

      // 検索ボックスのメールアドレス取得
      var mail = $.trim($("#login-email").val());

	  // JSONファイルの読み込み
	  $.getJSON("json/data.json", function(data){

	    // 検索ボタンを押した場合は、検索ボックスの入力有無に関わらず、すべてのデータを表示

        // 要素削除
        $("#tb-meisai tr").remove();

        for(var i in data){
    	    var num = parseInt(i, 10) +1;
    	    // チェックブックスのvalue用
    	    var val = "val" + num
    	    // 画面表示
    	  $("#tb-meisai").append(
    	   	$("<tr>")
    	    .append($("<td><input type=\"checkbox\" name=\"check\" value=" + val + "\></td>"))
    	    .append($("<td>" + num + "</td>"))
    	    .append($("<td>" + data[i].email + "</td>"))
    	    .append($("<td>" + data[i].passwd + "</td>"))
    	    .append($("<td>" + data[i].insdate + "</td>"))
    	    .append($("<td>" + data[i].upddate + "</td></tr>\n"))

    	  );
	    }
        if (mail != "") { // メールアドレスの入力がある場合、
		    // 正規表現使用
		    var regExp = new RegExp(mail);

		    // 検索文字列と一致するメールアドレスが存在する行を表示する
		    // todo hideで隠しているだけなので、新規の時の連番がおかしくなるため、jsondataから検索してヒットしたものだけを表示する日追うr
		    $('#tb-meisai').find('tr').hide().each(function(){
		        var tr = $(this);
		        $(this).find('td').eq(2).each(function(){
		            if ($(this).text().match(regExp)) {
		                tr.show();
		            }
		        })
		    });
		}

	  });
	});


    /*******************************
     * 関数名 |
     * 概要   | 新規ボタンクリック時
     ******************************/
    $("#insert").click(function(){

      // モード変更
      $("#mode").text("新規モード");

      // 新規行追加
      addrow();

    })

     /*******************************
     * 関数名 |
     * 概要   | 実行ボタンクリック時
     ******************************/
    $("#submit").click(function(){

      // 入力値格納用配列
      var checkval = [];
      var email = [];
      var passwd = [];
      var insdate = [];
      var upddate = [];

      // 選択済み行のみ取得
      $('input[name="check"]:checked').each(function() {

        // value値を配列に格納
        checkval.push($(this).val());

        // 選択済み行の入力値を配列に格納      ※選択checkbox→td要素→input type=text
        email.push($(this).parent().parent().find('td').eq(2).find("input").val());
        passwd.push($(this).parent().parent().find('td').eq(3).find("input").val());
        insdate.push($(this).parent().parent().find('td').eq(4).find("input").val());
        upddate.push($(this).parent().parent().find('td').eq(5).find("input").val());



      });

      $.ajax({
              url: 'sample',
              type: 'POST',
              dataType: 'html',
              data : {"email" : email, "passwd" : passwd }
      }).done(function(data) {
                        alert("ok");
      }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
                       console.log("NG:" + textStatus);
                       alert("error");
      })


      // 入力チェック
      inputcheck();


    })

    /*******************************
     * 関数名 | addrow
     * 概要   | 新規行追加
     ******************************/
    function addrow(){
      var element = document.getElementById("tb-meisai") ;
      var row = element.insertRow(-1);
      var val = "val" + String(tbl.rows.length -1);

      // セルの挿入
      var cell1 = row.insertCell(-1);
      var cell2 = row.insertCell(-1);
      var cell3 = row.insertCell(-1);
      var cell4 = row.insertCell(-1);
      var cell5 = row.insertCell(-1);
      var cell6 = row.insertCell(-1);

      // セルの内容入力
      cell1.innerHTML = "<input type=\"checkbox\" name=\"check\" value=" + val + "\></td>";
      cell2.innerHTML = tbl.rows.length -1;
      cell3.innerHTML = "<input type=\"text\" value=\"\" size=\"30\" maxlength=\"50\" />";
      cell4.innerHTML = "<input type=\"text\" value=\"\" size=\"10\" maxlength=\"15\" />";
      cell5.innerHTML = "<input type=\"text\" value=\"\" size=\"8\" maxlength=\"8\" />";
      cell6.innerHTML = "<input type=\"text\" value=\"\" size=\"8\" maxlength=\"8\" />";
    }

    /*******************************
     * 関数名 | inputcheck
     * 概要   | 入力チェック
     ******************************/
    function inputcheck(){

      // 入力メールアドレスの重複チェック
    }

});