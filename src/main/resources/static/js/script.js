function displayAlert() {
    alert("javascript online")
}

async function deleteComment(commentId) {
  const response = await fetch(`http://localhost:8080/comments/${commentId}`, {
    method: 'DELETE',
    redirect: 'follow',
  });

  location.reload();
}