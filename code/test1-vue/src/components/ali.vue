<template>
    <div>
        <div id="video-box">
            <div class="prism-player" id="J_prismPlayer" ></div>
        </div>
    
        <button @click="playLesson('https://video.pearvideo.com/mp4/third/20200914/cont-1697045-15591790-160052-hd.mp4')">视频1</button>
        <button @click="playLesson('https://video.pearvideo.com/mp4/third/20200913/cont-1696928-15623159-160858-hd.mp4')">视频2</button>
    </div>
</template>

<script>
export default {
    name: "ali",
    components: {},
    data() {
        return {
            player:null,
        };
    },
    mounted(){
        this.player = new Aliplayer({
            id: 'J_prismPlayer',
            width: '100%',
            height: '900px',
            autoplay: true,
            //支持播放地址播放,此播放优先级最高
            source : '',
        });

    },
    methods:{
        playLesson(id){
            // 每次重新创建 播放器 （否则视频会被叠加）
            document.getElementById("J_prismPlayer").remove();
            var str = '<div class="prism-player" id="J_prismPlayer"></div>';
            var pdiv = document.createElement("div");
            pdiv.setAttribute("class","prism-player");
            pdiv.setAttribute("id","J_prismPlayer");
			document.getElementById("video-box").appendChild(pdiv);
            
            this.player = new Aliplayer({
                id: 'J_prismPlayer',
                width: '100%',
                height: '900px',
                autoplay: true,
                //支持播放地址播放,此播放优先级最高
                source : id,
            });
        }
    }
     
}
</script>

<style scoped>

</style>