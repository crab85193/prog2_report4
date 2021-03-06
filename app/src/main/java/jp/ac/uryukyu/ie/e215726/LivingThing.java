package jp.ac.uryukyu.ie.e215726;

/**
 * 生物クラス。
 *  String name; //生物の名前
 *  int hitPoint; //生物のHP
 *  int attack; //生物の攻撃力
 *  boolean dead; //生物の生死状態。true=死亡。
 * Created by CrabAnderson on 2021/12/06.
 */
public class LivingThing {
    String name;
    int hitPoint;
    int attack;
    boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 生物の名前
     * @param maximumHP 生物のHP
     * @param attack 生物の攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * 名前を取得するメソッド。
     * @return 生物の名前
     */
    public String getName(){
        return name;
    }

    /**
     * ヒットポイントを取得するメソッド。
     * @return モンスターのヒットポイント
     */
    public int getHitPoint(){
        return hitPoint;
    }

    /**
     * 攻撃力を取得するメソッド。
     * @return モンスターの攻撃力
     */
    public int getAttack(){
        return attack;
    }

    /**
     * 生存状態を取得するメソッド。
     * @return 生物の生存状態
     */
    public boolean isDead(){
        return dead;
    }

    /**
     * 名前を設定するメソッド。
     * @param name モンスターの名前
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * ヒットポイントを設定するメソッド。
     * @param hitPoint モンスターのヒットポイント
     */
    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    /**
     * 攻撃力を設定するメソッド。
     * @param attack モンスターの攻撃力
     */
    public void setAttack(int attack){
        this.attack = attack;
    }

    /**
     * 生存状態を設定するメソッド。
     * @param dead モンスターの生存状態
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }

    /**
     * 自分以外の生物へ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、livingThing.wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
     */
    public void attack(LivingThing opponent){
        if( !dead ){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint <= 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
