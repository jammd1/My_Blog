import React from "react";
import profileImage from "../assets/profileImage.png";
import './ProfileImage.css';

function ProfileImage() {
    return (
        <div className="profile-image">
            <img
            src={profileImage}
            alt="프로필 이미지"
            />
        </div>
    );
}
export default ProfileImage;