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
					$("#heartA").text('Liked');
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
	
	
	$("#toggleLike").on("load", loadReportLike);
	$("#toggleLike").click(reportLike);
	
	    function fillModal(sCom, sAut, sCid) { 
	    	const a1 = sCid;
	    	console.log(a1)
	    	const a2 = sAut;
	    	console.log(a2)
	    	const a3 = sCom;
	    	console.log(a3)
	    	$('#comUpCID').val(a1);
	    	$('#comUpAUN').val(a2);
	    	$('#tinyComUpCON').val(a3);
	    	}
	    
	    	$('textarea#tinyComUpCON').tinymce({ height: 500, });
	    	$('textarea#tiny').tinymce({ height: 500, });
	    	
	    	/* function validate(){
				var val1 = $('').val();
				var val2 = $('').val();
				var val3 = $('').val();
				var val4 = $('').val();
				if(val1.length < x){
					$('registerForm').reportValidity();
					return false;
				}
				if(val2.length < x){
					$('registerForm').reportValidity();
					return false;
				}
				if(val3.length < x){
					$('registerForm').reportValidity();
					return false;
				}
				if(val4.length < x){
					$('registerForm').reportValidity();
					return false;
				}
				
				return true;
			} */

	});
	