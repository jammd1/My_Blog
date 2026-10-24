import { useEffect, useState } from "react";
import { useParams } from "react-router";
import { fetchPost } from "./posts.jsx";
import SectionDivider from "./components/SectionDivider.jsx";

const dateFormatter = new Intl.DateTimeFormat("ko-KR", {
    dateStyle: "long"
});

function PostDetail() {
    const { postId } = useParams();
    const [post, setPost] = useState(null);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetchPost(postId)
            .then(setPost)
            .catch((reqError) => setError(reqError.message));
    }, [postId]);

    if (error) {
        return <p>{error}</p>;
    }

    if (!post) {
        return <p>게시글을 불러오는 중입니다.</p>
    }

    const formattedCreatedAt = dateFormatter.format(new Date(post.createdAt));

    return (
        <main>
            <article>
                <h1>{post.title}</h1>
                <SectionDivider/>
                <time dateTime={post.createdAt}>
                    {formattedCreatedAt}
                </time>
                <p>{post.content}</p>
            </article>
        </main>
    );
}

export default PostDetail;