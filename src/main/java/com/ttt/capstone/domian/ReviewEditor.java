package com.ttt.capstone.domian;

import lombok.Getter;

@Getter
public class ReviewEditor {
    private String title;
    private String content;
    public ReviewEditor(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public static ReviewEditor.ReviewEditorBuilder builder() {
        return new ReviewEditor.ReviewEditorBuilder();
    }
    public static class ReviewEditorBuilder {
        private String title;
        private String content;

        ReviewEditorBuilder() {
        }
        public ReviewEditor.ReviewEditorBuilder title(final String title) {
            if (title != null) {
                this.title = title;
            }
            return this;}
        public ReviewEditor.ReviewEditorBuilder content(final String content) {
            if(content != null) {
                this.content = content;
            }
            return this;
        }
        public ReviewEditor build() {
            return new ReviewEditor(this.title, this.content);
        }
        public String toString() {
            return "ReviewEditor.ReviewEditorBuilder(title=" + this.title + ", content=" + this.content + ")";
        }
    }
}
