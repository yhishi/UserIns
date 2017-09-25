$(document).ready(function() {

	// モードはデフォルト検索
	var mode = "search";
	$("#mode").text("検索モード");

    /*******************************
    * 関数名 |
    * 概要   | 検索ボタンクリック時
    ******************************/
	$("#search").click(function(){

      // 検索ボックスのメールアドレス取得
      var email = $.trim($("#login-email").val());

      $.ajax({
        url: 'Search',
        type: 'POST',
        dataType: 'json', // レスポンスの データ形式
        data : {'email' : email}

      }).done(function(data) {
                  alert("success");
				  //要素削除
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
				   		.append($("<td>" + data[i][0] + "</td>"))
				   		.append($("<td>" + data[i][1] + "</td>"))
				   		.append($("<td>" + data[i][2] + "</td>"))
				   		.append($("<td>" + data[i][3] + "</td></tr>\n"))
				  	);
				  }

      }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
                 console.log("NG:" + textStatus);
                 alert("error");
      })

      /***** ローカルJSONファイル読み込んで画面表示 start
       *  2017/8/20 DBから読み込むように修正するため、コメントアウト

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
		** ローカルJSONファイル読み込んで画面表示 end */

	  });


    /*******************************
     * 関数名 |
     * 概要   | 新規ボタンクリック時
     ******************************/
    $("#insert").click(function(){

      // モード変更
      $("#mode").text("新規モード");
      mode = "insert";

      // 新規行追加
      addrow();

    });

    /*******************************
     * 関数名 |
     * 概要   | 更新ボタンクリック時
     ******************************/
    $("#update").click(function(){

      // モード変更
      $("#mode").text("更新モード");
      mode = "update";


    });

    /*******************************
     * 関数名 |
     * 概要   | 削除ボタンクリック時
     ******************************/
    $("#delete").click(function(){

      // モード変更
      $("#mode").text("削除モード");
      mode = "delete";


    });

     /*******************************
     * 関数名 |
     * 概要   | 実行ボタンクリック時
     ******************************/
    $("#submit").click(function(){

	  var insdata = [];
	  var checkval = [];

      var email = "";
      var passwd = "";
      var insdate = "";
      var upddate = "";

      // 選択済み行のみ取得
      $('input[name="check"]:checked').each(function() {

    	// value値を配列に格納
    	checkval.push($(this).val());

    	// 選択済み行の入力値を配列に格納      ※選択checkbox→td要素→input type=text
        email = ($(this).parent().parent().find('td').eq(2).find("input").val());
        passwd = ($(this).parent().parent().find('td').eq(3).find("input").val());
        insdate = ($(this).parent().parent().find('td').eq(4).find("input").val());
        upddate = ($(this).parent().parent().find('td').eq(5).find("input").val());

        insdata.push({ 'email': email, 'passwd': passwd, 'insdate': insdate , 'upddate': upddate });
      });


	  // formでPostで送信
	  var form = document.createElement('form');
	  form.action = 'sample';
      form.method = 'POST';
	  document.body.appendChild(form);

	  // パラメータ設定
	  if (insdata !== undefined) {
	    var input = document.createElement('input');
	    input.setAttribute('type', 'hidden');
	    input.setAttribute('name', 'input');
	    input.setAttribute('value', JSON.stringify(insdata));
	    form.appendChild(input);
	  }

	  form.submit();

      //連想配列をobjectに変換
//	  var test_obj = {};
//	  for(key in insdata){
//		test_obj [key] = insdata[key];
//	  }

//      $.ajax({
//              url: 'sample',
//              type: 'POST',
//              dataType: 'json', // レスポンスの データ形式なので記載不要？
//              //contentType: 'application/json',
//        	  //data : JSON.stringify(insdata)
//        	  //data: JSON.stringify(test_obj)
//        	  //data: JSON.stringify({'test_obj': test_obj})
//        	  data: {'email': email, 'passwd': passwd, 'insdate': insdate , 'upddate': upddate}
//        	  //traditional: true
//              //data : {'name' : "鈴木", 'age': 33 }
//      }).done(function(data) {
//                        alert("success");
//      }).fail(function(XMLHttpRequest, textStatus, errorThrown) {
//                       console.log("NG:" + textStatus);
//                       alert("error");
//      })


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