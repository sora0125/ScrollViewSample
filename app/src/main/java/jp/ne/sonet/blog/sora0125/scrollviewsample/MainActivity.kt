package jp.ne.sonet.blog.sora0125.scrollviewsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.text.HtmlCompat
import android.support.v4.text.HtmlCompat.FROM_HTML_MODE_COMPACT
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import android.util.Log
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    private val TAG = this.javaClass.simpleName
    lateinit var bu: Button
    lateinit var tv: TextView
    lateinit var sv: ScrollView
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sv = findViewById(R.id.scrollView)
        editText = findViewById(R.id.edittext)

        bu = findViewById(R.id.button)
        bu.setOnClickListener{
            Log.d(TAG, "button tap")

            // 検索対象のテキスト取得
            val searchText = editText.text.toString()
            // テキストビューのテキストを取得
            var fullText = tv.text.toString()
            Log.d(TAG, "fullText:$fullText")
            // テキスト内に検索対象の文字があるかチェック
            if (fullText.contains(searchText)) {

                // 一致した文字の位置を取得（0開始）
                val indexOfSearchText = fullText.indexOf(searchText)
                Log.d(TAG, "indexOfSearchText:$indexOfSearchText")
                // 文字の位置から検索文字の行数を取得（0開始）
                val lineNumber = tv.layout.getLineForOffset(indexOfSearchText)
                Log.d(TAG, "lineNumber:$lineNumber")
                val highlighted = "<font color='red'>$searchText</font>"
                Log.d(TAG, "highlighted:$highlighted")
                fullText = fullText.replace(searchText, highlighted)
                Log.d(TAG, "fullText replace:$fullText")
                // htmlに対応するため
                fullText = fullText.replace("\n", "<br />")
                Log.d(TAG, "fullText replace:$fullText")
                tv.text = HtmlCompat.fromHtml(fullText, FROM_HTML_MODE_COMPACT)
                Log.d(TAG, "tv.text:${tv.text}")
                // 指定した行までの高さを取得
                val targetHeight = tv.layout.getLineTop(lineNumber)
                Log.d(TAG, "targetHeight:$targetHeight")
                // スクロールさせる
                sv.smoothScrollTo(0, targetHeight)
            }

        }

        tv = findViewById(R.id.textView)
        tv.text = "余が化学を修め始めたるは明治十三年余が十七歳の時にして、主としてロスコー、ファウン＝ミルラー、ミューアなどの英書に就きて斯学の初歩を講じたるものなるが、多くもあらぬ小遣銭は尽く薬品器具の購入に費し、家人の迷惑をも顧みず酸類にて衣服や畳に孔を穿ち又硫化水素などを弄びて実験を行ふを唯一の楽とせり。余は当時大阪衛生試験所長兼造幣局技師たりし村橋次郎先生に就きて毎週一回講学上の疑を質し実験上にも指導を蒙りたること少からず。余は其の頃殆ど純正化学と応用化学との別を弁へず化学上の事柄は其の理論的たると応用的たるとに論なく均しき興味を以て之を学びたり。明治十五年大学予備門に入るに及び大学の学風に薫化せられて眼界の頓に開展するを覚え知識的興味は多様となりたるも化学に対する執着は変ることなく寄宿舎に於ても試験管を弄するを止めざりき。進て大学理学部に入るに及んで桜井教授の薫陶を受け理論化学を専攻することとなりたるも応用化学に対する興味は依然として之を持続せり。されば余が大学に於て物理化学を講ずるに当りて相律、反応速度論、化学平衡等に於て実例を挙ぐる場合には諸種の製造法即ち応用化学的工程を説示するに勉めたり。\n" +
                "　今日に於てこそ純正化学と其の応用との関係は稍々世人に理解せらるるに至りたれども二十年三十年前に在ては純正化学は数学、星学などと同じく工業とは頗る縁遠きものと一般に認められ居たり。此の事実は純正化学を修めたる大学卒業者の就職と密接の関係を有し当時の卒業者は大学、高等工業学校、高等学校等の教職を除きては殆んど就職の途なき有様を呈せり。唯当時卒業者の数少く而して新設せらるゝ学校の数多かりしを以て現今の如く就職難を訴ふることなかりしと雖も其の前途に於ける活動分野の狭隘なりしことは余が常に憂慮したる所にして余は機会あらば自から応用方面に於て成績を挙げ純正化学者が工業上より見て無用の長物に非ざることを例示せんと窃に企図し居たり。\n" +
                "　明治四十年五二会の競進会より余が妻は一束の好良なる昆布を求め来れり。余之を見て思へらく眼を悦ばす美麗なる色素や嗅覚を楽ましむる馥郁たる香料は化学工業によりて数多く製造されつゝあれども味覚に訴ふる製品はサッカリンの如き恠し気なる甘味料を除きては殆んど稀なり、昆布の主要呈味成分の研究は或は此の欠点を補ふ一助たるべきなりと。即ち其の昆布を携へて実験室に至り浸出液を造り粘質物を除き無機塩類及びマンニットを結晶せしめて除去したるに呈味物質は依然として残液中に存し、種々之を分離せんと試みたるも其の目的を達せず、当時他の研究に多忙の際なりしかば此の専門外の実験は一時之を中止することとせり。\n" +
                "　翌四十一年に至り東洋学芸雑誌上に於て三宅秀博士の論文を読みたるに佳味が食物の消化を促進することを説けるに逢へり。余も亦元来我国民の栄養不良なるを憂慮せる一人にして如何にして之を矯救すべきかに就て思を致したること久しかりしが終に良案を得ざりしに此の文を読むに及んで佳良にして廉価なる調味料を造り出し滋養に富める粗食を美味ならしむることも亦此の目的を達する一方案なるに想到し、前年来中止せる研究を再び開始する決意を為せり。\n" +
                "　貧は諸道の妨なりといふ俚諺は若冠の頃より係累多く絶えず窮鬼と戦ひつゝありし余の痛切に体験したる所にして、此の窮境を脱せんとの願望も亦余をして応用方面に転向せしめたる一の潜在動機たりしことを否む能はず。昆布の主要呈味成分の研究は案外容易に成功せり、前に記したる残液（約十貫目の最良昆布より製したるもの）に鉛塩を加へて生ずる沈澱よりグルタミン酸約三十瓦を製し得たることによりて問題は解決せられ、其の余は単に最も有利なる製造の諸条件及び使用上最も便利なる製品を決定するに止まり、学術上より見れば余の発明は頗る簡単なる事柄なりしなり。\n" +
                "「味の素」が広く世に行はれ幾分にても国民栄養の上に貢献する所ありとせば其は主として製造者たる鈴木氏の宣伝の功に帰せざるべからず、余は唯当初の目的の過半達成せられたるを欣ぶものなり。"
//        tv.text = "1\n2\n3\n4\n5\n1\n1あああ\n1\n1\n10\n1\n1\n1\n1\n1\n1\n1\n1\n1\n20\n1\n1あああ\n1\n1\n1\n1\n1\n1\n1\n30\n" +
//                "31\n2\n3\n4\n5\n1\n1\n1\n1\n40\n1\n1\n1\n1\n1\n1\n1\n1\n1\n50\n1\n1いいい\n1\n1\n1\n1\n1\n1\n1\n60" +
//                "61\n2\n3\n4\n5\n1\n1\n1\n1\n70\n1\n1\n1\n1\n1\n1うううう\n1\n1\n1\n80\n1\n1\n1\n1\n1\n1\n1\n1\n1\n90\n1\n1\n1\n"

    }
}
