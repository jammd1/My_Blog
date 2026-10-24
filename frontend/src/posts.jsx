export async function fetchPosts() {
    const response = await fetch('/api/posts');

    if (!response.ok) {
        throw new Error("게시글 목록을 불러오지 못했습니다.");
    }

    return response.json();
}

export async function fetchPost(postId) {
    const response = await fetch(`/api/posts/${postId}`);

    if (!response.ok) {
        throw new Error("게시글을 불러오지 못했습니다.");
    }

    return response.json();
}