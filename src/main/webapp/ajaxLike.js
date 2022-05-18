/**
 * 
 */
 
 	/* function toggle() {
		var postid = ;
		var usernum = ;
		var liketype = ;
		reportLike()
		
		if(){
			createLike();
		}else if(){
			deleteLike();
		}
	
	} */
	
	$(document).ready(function(){
		
	var likeTypeVal;
	
	function createLike() {
		var postid = $("#postid").text();
		var usernum = $("#usernum").text();
		console.log("create function runs");
		console.log(postid);
		console.log(usernum);
		$.ajax({
			type : "POST",
			url : "createLike.action",
			data : "postID=" + postid + "&userNum=" + usernum,
			success : function(data) {
				var ht = data.msg;
				$("#message").html(ht);
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
	}
	
	function deleteLike() {
		var postid = $("#postid").text();
		var usernum = $("#usernum").text();
		console.log("delete function runs");
		console.log(postid);
		console.log(usernum);
		$.ajax({
			type : "POST",
			url : "deleteLike.action",
			data : "postID=" + postid + "&userNum=" + usernum,
			success : function(data) {
				var ht = data.msg;
				$("#message").html(ht);
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
	}
	
	function reportLike() {
		var postid = $("#postid").text();
		var usernum = $("#usernum").text();
		console.log("report function runs");
		console.log(postid);
		console.log(usernum);
		$.ajax({
			type : "POST",
			url : "reportLike.action",
			data : "postID=" + postid + "&userNum=" + usernum,
			success : function(data) {
				var ht = data.likeType;
				console.log("liketype check: "+ht)
				$("#message").html(ht);
				if(ht === 0){
					console.log("create");
					createLike();
				}else if(ht === 1){
					console.log("delete");
					deleteLike();
				}
			},
			error : function(data) {
				alert("Some error occured.");
			}
		});
	}
	/* $("#lc").click(createLike);
	$("#ld").click(deleteLike);
	$("#lr").click(reportLike); */
	
	$("#toggleLike").click(reportLike);

	});
	