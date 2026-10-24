import {Link} from "react-router";

const dateFormatter = new Intl.DateTimeFormat("ko-KR", {
    dateStyle: "long"
});

function PostListItem({ post }) {
    const formattedCreatedAt = dateFormatter.format(
        new Date(post.createdAt)
    );

    return (
        <li className="post-list-item">
            <Link to={`/posts/${post.id}`}>
                <h2>{post.title}</h2>
            </Link>
            <time dateTime={post.createdAt}>
                {formattedCreatedAt}
            </time>
        </li>
    );
}

export default PostListItem;