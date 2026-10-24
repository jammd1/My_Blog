import React from 'react';
import ProfileImage from "./ProfileImage.jsx";
import './HomeHeader.css';

function HomeHeader() {
    return (
        <div className="home-header">
            <ProfileImage/>
            <h1>jammd1의 개인 블로그</h1>
        </div>
    );
}

export default HomeHeader;