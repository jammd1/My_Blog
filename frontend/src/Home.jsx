import {useEffect, useState} from "react";
import {fetchPosts} from "./posts.jsx";
import HomeHeader from "./components/HomeHeader.jsx";
import SectionDivider from "./components/SectionDivider.jsx";
import PostListItem from "./components/PostListItem.jsx";

function Home() {
    const [posts, setPosts] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        fetchPosts()
            .then(setPosts)
            .catch((reqError) => setError(reqError.message));
    }, []);

    if (error) {
        return <p>{error}</p>;
    }

    if (!posts) {
        return <p>게시글 목록을 불러오는 중입니다.</p>
    }

    return (
        <main>
            <HomeHeader/>
            <SectionDivider/>
            {posts.length >= 1 &&  <ul className="post-list">
                {posts.map((post) => (
                    <PostListItem key={post.id} post={post}/>
                ))}
            </ul>}
            {posts.length === 0 && <p>조회된 게시글이 없습니다.</p>}
        </main>
    );
}

export default Home;